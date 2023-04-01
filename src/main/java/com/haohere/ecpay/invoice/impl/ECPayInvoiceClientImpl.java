package com.haohere.ecpay.invoice.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haohere.ecpay.invoice.ECPayInvoiceClient;
import com.haohere.ecpay.invoice.constants.ECPayInvoiceConstants;
import com.haohere.ecpay.invoice.exception.ECPayInvoiceException;
import com.haohere.ecpay.invoice.models.base.BaseRequest;
import com.haohere.ecpay.invoice.models.base.BaseResponse;
import com.haohere.ecpay.invoice.models.base.RqHeader;
import com.haohere.ecpay.invoice.models.request.*;
import com.haohere.ecpay.invoice.models.response.*;
import com.haohere.ecpay.invoice.util.AES;
import okhttp3.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author haohao
 * @date 2022/4/27
 */
public class ECPayInvoiceClientImpl implements ECPayInvoiceClient {

    private final String hashKey;
    private final String hashIV;
    private final String merchantID;
    private final String baseUrl;
    private final ObjectMapper objectMapper;

    private final OkHttpClient client = new OkHttpClient();


    public ECPayInvoiceClientImpl(String hashKey, String hashIV, String merchantID) {
        this.hashKey = hashKey;
        this.hashIV = hashIV;
        this.merchantID = merchantID;
        this.baseUrl = ECPayInvoiceConstants.PROD_URL;
        this.objectMapper = new ObjectMapper();
    }

    public ECPayInvoiceClientImpl() {
        this.hashKey = ECPayInvoiceConstants.TEST_HASH_KEY;
        this.hashIV = ECPayInvoiceConstants.TEST_HASH_IV;
        this.merchantID = ECPayInvoiceConstants.TEST_MERCHANT_ID;
        this.baseUrl = ECPayInvoiceConstants.TEST_URL;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public IssuingInvoiceResponse createInvoice(IssuingInvoiceRequest model) {

        var issuingInvoiceResponseDto = new IssuingInvoiceResponse();


        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "Issue"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    issuingInvoiceResponseDto = objectMapper.readValue(actual, IssuingInvoiceResponse.class);
                    issuingInvoiceResponseDto.relateNumber = model.relateNumber;

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return issuingInvoiceResponseDto;
    }

    @Override
    public QueryInvoiceInfoResponse queryInvoice(QueryInvoiceInfoRequest model) {

        var queryInvoiceInfoResponse = new QueryInvoiceInfoResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "GetIssue"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    queryInvoiceInfoResponse = objectMapper.readValue(actual, QueryInvoiceInfoResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return queryInvoiceInfoResponse;
    }

    @Override
    public InvalidInvoiceResponse invalidInvoice(InvalidInvoiceRequest model) {

        var invalidInvoiceResponse = new InvalidInvoiceResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "Invalid"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    invalidInvoiceResponse = objectMapper.readValue(actual, InvalidInvoiceResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return invalidInvoiceResponse;
    }


    @Override
    public IssuingAllowanceResponse createAllowance(IssuingAllowanceRequest model) {
        var issuingAllowanceResponse = new IssuingAllowanceResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "Allowance"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    issuingAllowanceResponse = objectMapper.readValue(actual, IssuingAllowanceResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return issuingAllowanceResponse;
    }

    @Override
    public IssuingAllowanceByCollegiateResponse createAllowanceByCollegiate(IssuingAllowanceByCollegiateRequest model) {

        var issuingAllowanceByCollegiateResponse = new IssuingAllowanceByCollegiateResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "Allowance"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    issuingAllowanceByCollegiateResponse = objectMapper.readValue(actual, IssuingAllowanceByCollegiateResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return issuingAllowanceByCollegiateResponse;
    }


    @Override
    public InvalidAllowanceResponse invalidAllowance(InvalidAllowanceRequest model) {

        var invalidAllowanceResponse = new InvalidAllowanceResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "AllowanceInvalid"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    invalidAllowanceResponse = objectMapper.readValue(actual, InvalidAllowanceResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return invalidAllowanceResponse;
    }

    @Override
    public InvalidAllowanceByCollegiateResponse invalidAllowanceByCollegiate(InvalidAllowanceByCollegiateRequest model) {

        var invalidAllowanceByCollegiateResponse = new InvalidAllowanceByCollegiateResponse();

        try {

            model.merchantID = merchantID;

            var body = handleBaseRequest(model);

            Request request = new Request.Builder()
                    .url(String.format("%s%s", baseUrl, "AllowanceInvalidByCollegiate"))
                    .post(body)
                    .build();

            var response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                var responseResult = objectMapper.readValue(Objects.requireNonNull(response.body()).string(), BaseResponse.class);

                if (responseResult.transCode == 1) {

                    var result = AES.decrypt(responseResult.data.toString(), hashKey, hashIV);

                    if (result == null) throw new ECPayInvoiceException("AES decrypt failed");

                    var actual = URLDecoder.decode(result, StandardCharsets.UTF_8);

                    invalidAllowanceByCollegiateResponse = objectMapper.readValue(actual, InvalidAllowanceByCollegiateResponse.class);

                } else {
                    throw new ECPayInvoiceException(responseResult.transMsg);
                }
            }
        } catch (Exception e) {
            throw new ECPayInvoiceException(e);
        }

        return invalidAllowanceByCollegiateResponse;
    }

    private <T> RequestBody handleBaseRequest(T model) throws JsonProcessingException {

        var baseRequest = new BaseRequest();

        baseRequest.merchantID = merchantID;

        var rqHeader = new RqHeader();

        rqHeader.revision = ECPayInvoiceConstants.Revision;
        rqHeader.timestamp = System.currentTimeMillis() / 1000L;

        baseRequest.rqHeader = rqHeader;

        var serializeObject = objectMapper.writeValueAsString(model);

        var urlEncodeResult = URLEncoder.encode(serializeObject, StandardCharsets.UTF_8);

        baseRequest.data = AES.encrypt(urlEncodeResult, hashKey, hashIV);

        var serializeBaseRequestObject = objectMapper.writeValueAsString(baseRequest);

        return RequestBody.create(serializeBaseRequestObject, MediaType.get("application/json; charset=utf-8"));
    }
}
