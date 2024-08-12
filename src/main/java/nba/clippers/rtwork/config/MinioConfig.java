package nba.clippers.rtwork.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

import static org.apache.naming.SelectorContext.prefix;

@Data
@Component
@ConfigurationProperties(prefix="minio")
public class MinioConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * 访问地址
     */
    private String endpoint;

    /**
     * accessKey类似于用户ID，用于唯一标识你的账户
     */
    private String accessKey;

    /**
     * secretKey是你账户的密码
     */
    private String secretKey;

    /**
     * 默认存储桶
     */
    private String bucketName;

}
