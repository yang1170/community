package com.newcoder.community.service.imp;

import com.newcoder.community.service.MailClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Configuration
@Service
@Component
public class MailClient implements MailClientService {
    private static MailClient mailClient;
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);
    //启用日志
    //注入JavaMailSender
    @Autowired
    private JavaMailSender mailSender;
    //注入properties里的username值给from
    @Value("${spring.mail.username}")
    private String from;
    @PostConstruct
    public void init(){
        mailClient=this;
        mailClient.mailSender=this.mailSender;
    }
    public String senMail(String to,String subject,String content){
        try {
            //邮件内容
            MimeMessage message=mailClient.mailSender.createMimeMessage();
            //帮助构建邮件内容
            MimeMessageHelper helper=new MimeMessageHelper(message);
            helper.setFrom(from);	//发件人
            helper.setTo(to);	//收件人
            helper.setSubject(subject);	//主题
            helper.setText(content,true);	//内容和开启html
            mailClient.mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.error("发送邮件失败："+e.getMessage());
        }
        return "1";
    }
}
