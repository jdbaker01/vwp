package command;

public class SavePriceCommand {

    private final String symbol;
    private final String outputFolder;

    public SavePriceCommand(final String symbol, final String outputFolder) {
        this.symbol = symbol;
        this.outputFolder = outputFolder;
    }



}
