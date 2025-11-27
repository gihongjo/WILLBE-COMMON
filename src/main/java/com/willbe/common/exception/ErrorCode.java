package com.willbe.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SUCCESS("1000", "성공"),
    INVALID_REQUEST("1001", "잘못된 요청입니다"),
    UNAUTHORIZED("1002", "인증이 필요합니다"),
    FORBIDDEN("1003", "접근 권한이 없습니다"),
    NOT_FOUND("1004", "리소스를 찾을 수 없습니다"),

    USER_NOT_FOUND("2001", "사용자를 찾을 수 없습니다"),
    USER_ALREADY_EXISTS("2002", "이미 등록된 사용자입니다"),
    USER_DUPLICATE_UID("2003", "이미 존재하는 UID입니다"),
    USER_DUPLICATE_EMAIL("2004", "이미 존재하는 이메일입니다"),
    USER_INVALID_STATUS("2005", "사용할 수 없는 상태의 사용자입니다"),

    INVALID_TOKEN("3001", "유효하지 않은 토큰입니다"),
    TOKEN_EXPIRED("3002", "토큰이 만료되었습니다"),
    TOKEN_MALFORMED("3003", "토큰 형식이 올바르지 않습니다"),

    VALIDATION_ERROR("4001", "입력값 검증에 실패했습니다"),
    INVALID_EMAIL_FORMAT("4002", "이메일 형식이 올바르지 않습니다"),
    INVALID_UID_FORMAT("4003", "UID 형식이 올바르지 않습니다"),

    INTERNAL_SERVER_ERROR("5001", "서버 내부 오류가 발생했습니다"),
    DATABASE_ERROR("5002", "데이터베이스 오류가 발생했습니다"),
    EXTERNAL_SERVICE_ERROR("5003", "외부 서비스 연동 중 오류가 발생했습니다");

    private final String code;
    private final String message;
}

