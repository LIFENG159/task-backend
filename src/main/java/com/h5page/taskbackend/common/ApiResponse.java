package com.h5page.taskbackend.common;

/**
 * Standard API response wrapper used by all controllers.
 */
public class ApiResponse<T> {
    /** Business-level status code: 0 means success. */
    private final int code;
    /** Human-readable message for debugging or UI hints. */
    private final String message;
    /** Response payload, null when failed or empty. */
    private final T data;

    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /** Success response with payload. */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(0, "ok", data);
    }

    /** Failure response with error message. */
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(-1, message, null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
