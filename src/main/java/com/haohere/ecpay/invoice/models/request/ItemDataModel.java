package com.haohere.ecpay.invoice.models.request;

/**
 * 商品細項
 *
 * @author haohao
 * @date 2022/4/13
 */
public class ItemDataModel {

    /**
     * 商品序號
     */
    public int itemSeq;

    /**
     * 商品名稱
     */
    public String itemName;

    /**
     * 商品數量
     */
    public int itemCount;

    /**
     * 商品單位
     */
    public String itemWord;

    /**
     * 商品單價
     */
    public int itemPrice;

    /**
     * 商品課稅別
     */
    public String itemTaxType;

    /**
     * 商品合計
     */
    public int itemAmount;

    /**
     * 商品備註
     */
    public String itemRemark;

    public int getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(int itemSeq) {
        this.itemSeq = itemSeq;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemWord() {
        return itemWord;
    }

    public void setItemWord(String itemWord) {
        this.itemWord = itemWord;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemTaxType() {
        return itemTaxType;
    }

    public void setItemTaxType(String itemTaxType) {
        this.itemTaxType = itemTaxType;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }
}
