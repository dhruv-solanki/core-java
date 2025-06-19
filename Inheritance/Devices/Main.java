package Inheritance.Devices;

public class Main {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.capturePhoto();
        sp.recordVideo();
        sp.startPlayer();
        sp.stopPlayer();
    }
}
