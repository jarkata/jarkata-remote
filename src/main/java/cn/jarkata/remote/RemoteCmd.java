package cn.jarkata.remote;

public class RemoteCmd {

    public Result ssh(String username, String host, String command, int timeout) throws Exception {
        CmdBuilder builder = CmdBuilder.build();
        builder.append("ssh", buildLoginCmd(username, host)).append(command);
        return CmdExecutor.exec(builder.toList(), timeout);
    }

    public Result sudoSsh(String username, String host, String command, int timeout) throws Exception {
        CmdBuilder builder = CmdBuilder.build();
        builder.append("ssh", "-tty", buildLoginCmd(username, host)).append(command);
        return CmdExecutor.exec(builder.toList(), timeout);
    }


    public Result copyFileToRemote(String username, String host,
                                   String remotePath, String localPath,
                                   int timeout) throws Exception {
        return scp(username, host, remotePath, localPath,
                false, false, timeout);
    }

    public Result copyFileFromRemote(String username, String host,
                                     String remotePath, String localPath,
                                     int timeout) throws Exception {
        return scp(username, host, remotePath, localPath,
                true, false, timeout);
    }

    public Result copyDirectoryToRemote(String username, String host,
                                        String remotePath, String localPath,
                                        int timeout) throws Exception {
        return scp(username, host, remotePath, localPath,
                false, true, timeout);
    }

    public Result copyDirectoryFromRemote(String username, String host,
                                          String remotePath, String localPath,
                                          int timeout) throws Exception {
        return scp(username, host, remotePath, localPath,
                true, true, timeout);
    }

    public Result scp(String username, String host,
                      String remotePath,
                      String localPath,
                      boolean copyFromRemote, boolean copyDirectory,
                      int timeout) throws Exception {
        CmdBuilder builder = CmdBuilder.build().append("scp");
        if (copyDirectory) {
            builder.append("-r");
        }
        String buildRemotePath = buildRemotePath(username, host, remotePath);
        if (copyFromRemote) {
            builder.append(buildRemotePath).append(localPath);
        } else {
            builder.append(localPath).append(buildRemotePath);
        }
        return CmdExecutor.exec(builder.toList(), timeout);
    }

    private String buildRemotePath(String username, String host, String remotePath) {
        return buildLoginCmd(username, host) + ":" + remotePath;
    }


    private String buildLoginCmd(String username, String host) {
        return username + "@" + host;
    }
}