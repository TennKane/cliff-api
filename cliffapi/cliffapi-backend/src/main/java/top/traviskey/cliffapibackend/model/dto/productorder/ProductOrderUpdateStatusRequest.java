package top.traviskey.cliffapibackend.model.dto.productorder;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 关生
 */
@Data
public class ProductOrderUpdateStatusRequest implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    private Long id;

    private String status;
}
