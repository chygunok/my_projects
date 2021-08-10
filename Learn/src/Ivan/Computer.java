package Ivan;

public class Computer {
    class Ram{
        private boolean isStart = false;

        private void start(){
           isStart = true;
        }

        public void shutdown(){
            isStart = false;
        }
    }
    class Processor{
        private boolean isStart = false;

        private void start(){
            isStart = true;
        }

        public void shutdown(){
            isStart = false;
        }
    }

    Processor i7 = new Processor();
    Ram transfer = new Ram();

    public void start(){
        i7.start();
        transfer.start();
        System.out.println("Компьютер стартанул");
    }
}
