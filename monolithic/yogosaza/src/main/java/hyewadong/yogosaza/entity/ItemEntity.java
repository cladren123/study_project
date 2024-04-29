package hyewadong.yogosaza.entity;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ItemEntity {

    private Integer itemSeq;
    private Integer brandSeq;
    private Integer categoryId;
    private String itemCode;
    private String itemName;
    private Integer itemPrice;
    private String itemColor;
    private String itemSize;
    private LocalDateTime itemCreateDate;




}