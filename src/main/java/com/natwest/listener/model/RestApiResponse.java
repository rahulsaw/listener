package com.natwest.listener.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serial;
import java.io.Serializable;

/*
created by Rahul sawaria on 03/04/22
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestApiResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 3970313431174808013L;
    private boolean success;
    private MessageApiResponse error;
    private Object data;

    public static RestApiResponse buildSuccess(Object data) {
        return (new RestApiResponseBuilder()).success(Boolean.TRUE).data(data).build();
    }

    public static RestApiResponse buildSuccess() {
        return (new RestApiResponseBuilder()).success(Boolean.TRUE).build();
    }

    public static RestApiResponse buildFail(MessageApiResponse error) {
        return (new RestApiResponseBuilder()).success(Boolean.FALSE).error(error).build();
    }

    public static RestApiResponse buildFail(String name, String text) {
        return (new RestApiResponseBuilder()).success(Boolean.FALSE).error(MessageApiResponse.build(name, text)).build();
    }

    public static RestApiResponse buildFail() {
        return (new RestApiResponseBuilder()).success(Boolean.FALSE).build();
    }

    public static RestApiResponse buildFail(Object data) {
        return (new RestApiResponseBuilder()).success(Boolean.FALSE).data(data).build();
    }

    public static RestApiResponseBuilder builder() {
        return new RestApiResponseBuilder();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public MessageApiResponse getError() {
        return this.error;
    }

    public Object getData() {
        return this.data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setError(MessageApiResponse error) {
        this.error = error;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public RestApiResponse() {
    }

    public RestApiResponse(boolean success, MessageApiResponse error, Object data) {
        this.success = success;
        this.error = error;
        this.data = data;
    }

    public static class RestApiResponseBuilder {
        private boolean success;
        private MessageApiResponse error;
        private Object data;

        RestApiResponseBuilder() {
        }

        public RestApiResponseBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public RestApiResponseBuilder error(MessageApiResponse error) {
            this.error = error;
            return this;
        }

        public RestApiResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public RestApiResponse build() {
            return new RestApiResponse(this.success, this.error, this.data);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MessageApiResponse {
        private String code;
        private String message;

        public static MessageApiResponse build(String code, String message) {
            return (new MessageApiResponseBuilder()).code(code).message(message).build();
        }

        public static MessageApiResponseBuilder builder() {
            return new MessageApiResponseBuilder();
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setMessage(String message) {
            this.message = message;
        }


        public MessageApiResponse() {
        }

        public MessageApiResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public static class MessageApiResponseBuilder {
            private String code;
            private String message;

            MessageApiResponseBuilder() {
            }

            public MessageApiResponseBuilder code(String code) {
                this.code = code;
                return this;
            }

            public MessageApiResponseBuilder message(String message) {
                this.message = message;
                return this;
            }

            public MessageApiResponse build() {
                return new MessageApiResponse(this.code, this.message);
            }

            public String toString() {
                return "RestApiResponse.MessageApiResponse.MessageApiResponseBuilder(code=" + this.code + ", message=" + this.message + ")";
            }
        }
    }
}
