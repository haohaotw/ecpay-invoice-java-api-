package com.haohere.ecpay.invoice.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haohere.ecpay.invoice.models.base.BaseDataRequest;

import java.util.List;

/**
 * 開立折讓 (紙本同意)
 *
 * @author haohao
 * @date 2022/5/28
 */
public class IssuingAllowanceRequest extends BaseDataRequest {

    /**
     * 發票號碼
     */
    @JsonProperty(value = "InvoiceNo")
    public String invoiceNo;

    /**
     * 發票日期
     */
    @JsonProperty(value = "InvoiceDate")
    public String invoiceDate;

    /**
     * 通知類別
     * 開立折讓後，寄送將相關發票折讓資訊通知消費者
     * S：簡訊
     * E：電子郵件
     * A：皆通知時
     * N：皆不通知
     */
    @JsonProperty(value = "AllowanceNotify")
    public String allowanceNotify;

    /**
     * 顧客姓名
     */
    @JsonProperty(value = "CustomerName")
    public String customerName;

    /**
     * 通知信箱
     */
    @JsonProperty(value = "NotifyMail")
    public String notifyMail;

    /**
     * 通知手機號碼
     */
    @JsonProperty(value = "NotifyPhone")
    public String notifyPhone;

    /**
     * 折讓金額
     */
    @JsonProperty(value = "AllowanceAmount")
    public int allowanceAmount;

    @JsonProperty(value = "Items")
    public List<ItemDataModel> items;

    @JsonProperty(value = "Reason")
    public String reason;


}
