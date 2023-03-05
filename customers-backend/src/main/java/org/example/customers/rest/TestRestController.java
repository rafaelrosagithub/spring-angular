package org.example.customers.rest;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @GetMapping
    public String test() {
        System.out.println("Test");
        SFTP();
        return "test";
    }

    private void SFTP() {
        String localPath = "D:/FTP";
        String fileName = "filenovo.txt";
        String sftpHost = "192.168.0.110";
        String sftpPath = "/TESTSFTP";
        String sftpPort = "22";
        String sftpUser = "teste";
        String sftpPassword = "teste";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(sftpPassword);
            System.out.println("Connecting...");
            session.connect();
            System.out.println("Established Session: " + session.isConnected());

            Channel channel = session.openChannel("sftp");
            ChannelSftp channelSftp = (ChannelSftp) channel;
            channelSftp.connect();

            System.out.println("Opened sftp Channel");

            /**
             * TODO
             */
            System.out.println("Copying file to Host SFTP");
            channelSftp.put(localPath + "/" + fileName, sftpPath);
            System.out.println("Copied file to Host SFTP");

            System.out.println("Copying file from Host SFTP to Local");
            channelSftp.get(sftpPath + "/" + fileName, localPath);
            System.out.println("Copied file from Host SFTP to Local");

            // Changing directory name
            String oldDirName = sftpPath + "/EMAIL";
            String newDirName = oldDirName + "_done";
            channelSftp.rename(oldDirName, newDirName);

            // Changing the file name
            String oldFileName = sftpPath + "/" + fileName;
            String newNameFile;
            int lastIndex = oldFileName.lastIndexOf('.');
            if (lastIndex != -1) {
                newNameFile = oldFileName.substring(0, lastIndex);
                String newFileName = newNameFile + "_done" + ".txt";
                channelSftp.rename(oldFileName, newFileName);
            }

            // Remove file
            String file = "text1.txt";
            channelSftp.rm(sftpPath + file);

            // Remove directory
            String directory = "EMAIL";
            channelSftp.rm(sftpPath + directory);

            channelSftp.disconnect();
            session.disconnect();

            System.out.println("Disconnected from sftp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }


}
