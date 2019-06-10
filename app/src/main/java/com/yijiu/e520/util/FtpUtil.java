package com.yijiu.e520.util;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 */
public class FtpUtil {
    /**
     * 通过ftp上传文件
     *
     * @param url          ftp服务器地址 如： 192.168.1.110
     * @param port         端口如 ： 21
     * @param username     登录名
     * @param password     密码
     * @param remotePath   上到ftp服务器的磁盘路径
     * @param fileNamePath 要上传的文件路径
     * @param fileName     要上传的文件名
     *                     REMOTE_FTP_ADDRESS=192.168.1.213
     *                     REMOTE_FTP_USER=ftpadmin
     *                     REMOTE_FTP_PASS=666666
     *                     REMOTE_FTP_PORT =21
     *                     REMOTE_FTP_DIRECTORY_PROMOTION=/hmt
     *                     REMOTE_FTP_DIRECTORY_PADTOPIC=/hmt
     *                     FTP_ADDRESS=http://192.168.1.213/images
     * @return
     */
    public static String ftpUpload(String url, String port, String username, String password, String remotePath, String fileNamePath, String fileName) {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        String returnMessage = "0";
        try {
            ftpClient.connect(url, Integer.parseInt(port));
            boolean loginResult = ftpClient.login(username, password);
            int returnCode = ftpClient.getReplyCode();
            if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功
                ftpClient.makeDirectory(remotePath);
                // 设置上传目录
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                //处理中文名称的文件名，如果不加这一句的话，中文命名的文件是不能上传的
                fileName = new String(fileName.getBytes("GBK"), "iso-8859-1");
                ftpClient.enterLocalPassiveMode();
                fis = new FileInputStream(fileNamePath);
                // + fileName

                ftpClient.storeFile(fileName, fis);

                returnMessage = "1";
                //上传成功
                System.out.println("上传成功");
            } else {// 如果登录失败
                returnMessage = "0";
                System.out.println("上传错误");
            }


        } catch (IOException e) {
            returnMessage = "2";
        } finally {
            //IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
            }
        }
        return returnMessage;
    }
}
