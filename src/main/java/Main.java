import com.beust.jcommander.JCommander;

public class Main {

    public static void main(String ... argv) {
        Args args = new Args();
        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);
    }

    public void run() {

    }

}
