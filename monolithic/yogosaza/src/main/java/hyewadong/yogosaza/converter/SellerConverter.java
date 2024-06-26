package hyewadong.yogosaza.converter;

import hyewadong.yogosaza.dto.seller.SellerInputDto;
import hyewadong.yogosaza.domain.SellerDomain;

public class SellerConverter {

    public static SellerDomain sellerInputDtoToSellerDomain(SellerInputDto sellerInputDto) {
        return SellerDomain.builder()
                .brandSeq(sellerInputDto.getBrandSeq())
                .sellerId(sellerInputDto.getSellerId())
                .sellerPwd(sellerInputDto.getSellerPwd())
                .sellerName(sellerInputDto.getSellerName())
                .sellerPhone(sellerInputDto.getSellerPhone())
                .sellerAddress(sellerInputDto.getSellerAddress())
                .build();
    }

}
