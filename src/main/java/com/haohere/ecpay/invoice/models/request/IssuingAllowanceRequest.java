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

    @JsonProperty(value = "AllowanceNotify")
    public String allowanceNotify;

    @JsonProperty(value = "CustomerName")
    public String customerName;

    @JsonProperty(value = "NotifyMail")
    public String notifyMail;

    @JsonProperty(value = "NotifyPhone")
    public String notifyPhone;

    @JsonProperty(value = "AllowanceAmount")
    public int allowanceAmount;

    @JsonProperty(value = "Items")
    public List<ItemDataModel> items;

    @JsonProperty(value = "Reason")
    public String reason;


}
