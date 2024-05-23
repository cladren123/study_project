package hyewadong.yogosaza.service;

import hyewadong.yogosaza.config.PaginationConfig;
import hyewadong.yogosaza.converter.ItemConverter;
import hyewadong.yogosaza.dto.Page;
import hyewadong.yogosaza.dto.item.ItemInputDto;
import hyewadong.yogosaza.dto.item.ItemListDto;
import hyewadong.yogosaza.dto.item.ItemOutputDto;
import hyewadong.yogosaza.domain.ItemDomain;
import hyewadong.yogosaza.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemMapper itemMapper;
    private final PaginationConfig paginationConfig;

    // 상품 등록
    public int registerItem(ItemInputDto itemInputDto) throws SQLException {
        ItemDomain itemDomain = ItemConverter.itemInputDtoToItemDomain(itemInputDto);
        itemDomain.makeDate();
        return itemMapper.registerItem(itemDomain);
    }

    // 상품 조회
    public ItemOutputDto getItem(int itemSeq) throws SQLException {
        return itemMapper.getItem(itemSeq);
    }

    // 상품 전체 조회
    public List<ItemOutputDto> getItems() throws SQLException {
        return itemMapper.getItems();
    }

    // 상품 수정
    public int updateItem(ItemInputDto itemInputDto) throws SQLException {
        return itemMapper.updateItem(itemInputDto);
    }

    // 상품 삭제
    public int deleteItem(ItemInputDto itemInputDto) throws SQLException {
        return itemMapper.deleteItem(itemInputDto.getItemSeq());
    }

    // 상품들 조회 최신순
    public List<ItemListDto> getItemsByLatest(int offset) throws SQLException {
        return itemMapper.getItemsByLatest(offset, offset + paginationConfig.getPageSize());
    }

    // 상품들 조회 최신순 페이지
    public Page<ItemListDto> getItemPageByLatest(int page) throws SQLException {
        int size = paginationConfig.getPageSize();
        int totalContents = itemMapper.countItem();
        int totalPages = (totalContents + size - 1) / size;
        int end = totalContents - (page - 1) * size;
        int start = Math.max(end - size + 1, 0);

        List<ItemListDto> contents = itemMapper.getItemsByLatest(start, end);
        return new Page<>(page, totalPages, totalContents, contents);
    }





}
