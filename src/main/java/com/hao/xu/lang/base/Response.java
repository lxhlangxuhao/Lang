package com.hao.xu.lang.base;

/**
 * 响应对象
 *
 * @author 
 * @since 1.0.0
 */
public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;
    private Object items;
    private boolean success;

    public Response success() {
        this.meta = new Meta(true, OK);
        this.success=true;
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.success=true;
        this.data = data;
        return this;
    }
    
    public Response successItem(Object items) {
    	this.meta = new Meta(true, OK);
        this.items = items;
        this.success=true;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        this.success=false;
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        this.success=false;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public Object getItems() {
		return items;
	}

	public class Meta {

        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

	public boolean isSuccess() {
		return success;
	}	
	
}
