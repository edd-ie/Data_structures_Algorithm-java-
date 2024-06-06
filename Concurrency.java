public class Concurrency {

    private static class Singleton{
        private String name;
        private static Singleton instance;

        private Singleton(String name){
            this.name = name;
        }

        public static synchronized Singleton getInstance(String name){
            if(instance == null)
                instance = new Singleton(name);
            return instance;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println("Worker: "+(char)('a'+(2*i)));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                Singleton.getInstance("Worker");
                System.out.println(Singleton.getInstance("Worker").getName());
            }
        });

        t.start();

        for(int i = 0; i < 5; i++){
            System.out.println("Listener: "+ (char)('a'+((2*i)+1)));
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        Singleton.getInstance("Listener");
        Singleton.getInstance("Listener").setName("Listener");
        System.out.println(Singleton.getInstance("Listener").getName());
    }
}
