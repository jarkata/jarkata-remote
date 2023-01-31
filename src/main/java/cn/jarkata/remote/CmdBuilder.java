package cn.jarkata.remote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdBuilder {
    private final List<String> commandList = new ArrayList<>();

    private CmdBuilder() {
    }

    public static CmdBuilder build() {
        return new CmdBuilder();
    }

    public CmdBuilder append(String... commands) {
        commandList.addAll(Arrays.asList(commands));
        return this;
    }

    public List<String> toList() {
        return commandList;
    }

}