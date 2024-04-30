package top.traviskey.cliffapibackend.wxmp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;


/**
 * @author 关生
 */
@Data
public class CreateXcxQrRequestBodyRequest implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    private String scene;

    private String page;

    private boolean check_path;
}
