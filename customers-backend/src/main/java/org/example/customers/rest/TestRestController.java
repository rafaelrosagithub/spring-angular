package org.example.customers.rest;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @GetMapping
    public String test() throws ParseException {
        System.out.println("Test");

        LocalDateTime now = LocalDateTime.now();


        Timestamp date2 = Timestamp.valueOf(now);

        SFTP();
        return "test";
    }

    private void SFTP() {
        String localPath = "D:/FTP";
        String fileName = "filenovo.txt";
        String sftpHost = "192.168.0.110";
        String sftpPath = "/OficiosECM";
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
            Vector<ChannelSftp.LsEntry> fileList = channelSftp.ls(sftpPath);
            List<String> list = new ArrayList<>();
            for (ChannelSftp.LsEntry item : fileList) {

                if (item.getFilename().contains("_DONE")) {
                    String n = item.getFilename();
                    list.add(Arrays.toString(n.split("_")));
                }

                System.out.println(item.getFilename().toString());
            }

            System.out.println(list);
            list.forEach(n -> System.out.println(n));





//            if (fileList.size() > 0) {
//                System.out.println("QTD files: " + fileList.size());
//                fileList.stream().forEach(n -> {
//                   System.out.println(n);
//               });
//            } else {
//                System.out.println("QTD files: " + fileList.size());
//            }


//            System.out.println("Copying file to Host SFTP");
//            channelSftp.put(localPath + "/" + fileName, sftpPath);
//            System.out.println("Copied file to Host SFTP");

//            System.out.println("Copying file from Host SFTP to Local");
//            channelSftp.get(sftpPath + "/" + fileName, localPath);
//            System.out.println("Copied file from Host SFTP to Local");

            // Changing directory name
//            String oldDirName = sftpPath + "/EMAIL";
//            String newDirName = oldDirName + "_done";
//            channelSftp.rename(oldDirName, newDirName);

            // Changing the file name
//            String oldFileName = sftpPath + "/" + fileName;
//            String newNameFile;
//            String extensionFile;
//            int lastIndex = oldFileName.lastIndexOf('.');
//            if (lastIndex != -1) {
//                newNameFile = oldFileName.substring(0, lastIndex);
//                extensionFile = oldFileName.substring(lastIndex);
//
//                String newFileName = newNameFile + "_DONE" + extensionFile;
//                channelSftp.rename(oldFileName, newFileName);
//            }

            // Remove file
//            String file = "text1.txt";
//            channelSftp.rm(sftpPath + file);

            // Remove directory
//            String directory = "EMAIL";
//            channelSftp.rm(sftpPath + directory);

            channelSftp.disconnect();
            session.disconnect();

            System.out.println("Disconnected from sftp");
        } catch (Exception e) {
                e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }


}
