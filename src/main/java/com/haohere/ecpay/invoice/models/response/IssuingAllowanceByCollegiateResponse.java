package com.haohere.ecpay.invoice.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haohere.ecpay.invoice.models.base.BaseDataResponse;

/**
 * @author haohao
 * @date 2022/6/11
 */
public class IssuingAllowanceByCollegiateResponse extends BaseDataResponse {

    /**
     * 折讓單號
     * 開立成功，會回傳折讓單號；
     * 開立失敗，則會回傳空值。
     */
    @JsonProperty(value = "IA_Allow_No")
    public String iaAllowNo;

    /**
     * 發票號碼
     * 開立成功，會回傳當初開立的發票號碼；
     * 開立失敗，則會回傳空值。
     */
    @JsonProperty(value = "IA_Invoice_No")
    public String iaInvoiceNo;

    /**
     * 線上折讓時間
     * 建立成功，會回傳線上折讓時間
     * 回傳格式為「yyyy-MM-dd HH:mm:ss」；
     * 建立失敗，則會回傳空值
     */
    @JsonProperty(value = "IA_TempDate")
    public String iaTempDate;

    @JsonProperty(value = "IA_Date")
    public String iaDate;

    @JsonProperty(value = "IA_TempExpireDate")
    public String iaTempExpireDate;

    @JsonProperty(value = "IA_Remain_Allowance_Amt")
    public String iaRemainAllowanceAmt;
}
