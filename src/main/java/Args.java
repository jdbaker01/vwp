import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Args {

    @Parameter(names = "-symbols", description = "Comma-separated list of group names to be run")
    private List<String> symbols = new ArrayList<>();

}