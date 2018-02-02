package com.tutycarcare.commons.exception;

public class BusinessErrorCode {

	public static final int GENERIC_CODE = 4000; // Not used
	public static final int SESSION_EXPIRED = 4010;

	public static final int TOKEN_EXPIRED = 4011;
	public static final int TOKEN_NOT_SET = 4012;
	public static final int TOKEN_INVALID = 4013;

	public static final int EMAIL_NOT_EXISTS = 4100;
	public static final int INVALID_EMAIL = 4101;
	public static final int INVALID_PASSWORD = 4102;
	public static final int ACCOUNT_INACTIVE = 4103;

	public static final int MISSING_DATA = 4104;
	public static final int USER_EXISTS = 4105;
	public static final int NODE_EXISTS = 4106;
	public static final int USER_NOT_INVITED = 4107;

	public static final int INVALID_ANSWER = 4108;
	public static final int FORGOT_PASSWORD_INVALID_DATA = 4109;
	public static final int EMAIL_EXISTS = 4110;
	public static final int INVALID_ID = 4111;

	public static final int ACCOUNT_NOT_EXISTS = 4112;
	public static final int INCORRECT_PASSWORD = 4113;
	public static final int PRACTICE_NPI_NOT_VALID = 4114;
	public static final int PRACTICE_NPI_MISMATCH = 4115;
	public static final int PRACTICE_NPI_ALREADY_REGISTERED = 4116;

	public static final int INVALID_REQUEST = 4117;
	public static final int NODE_CANNOT_BE_DEACTIVATED = 4118;
	public static final int DEPENDENT_EXISTS = 4119;
	public static final int NOT_PERMITTED = 4120;
	public static final int NODE_IS_ALREADY_DISABLED = 4121;
	public static final int NODE_IS_ALREADY_ACTIVE = 4122;
	public static final int CANNOT_DELETE_PRIMARY_INSURANCE = 4123;
	public static final int INVALID_ROLE_PROVIDER = 4124;
	public static final int INVALID_ROLE_OM_OS = 4125;
	public static final int CANNOT_ADD_BILLING_UNDER_PRACTICE = 4126;
	public static final int BILLING_NODE_UNDER_PRACTICE = 4127;
	public static final int INVALID_PROPOSED_DATE = 4128;

	public static final int INVALID_NODE_ID = 4129;
	public static final int DUPLICATE_CODE = 4130;

	public static final int PASSWORD_LINK_EXPIRED = 4131;
	public static final int PASSWORD_LINK_INVALID = 4132;

	public static final int APPOINTMENT_CANNOT_BE_SCHEDULED = 4133;
	public static final int CANNOT_ADD_CHILD_UNDER_INDEPENDENT_PRACTICE = 4134;
	public static final int PENDING_APPOINTMENTS_PROVIDER = 4135;
	public static final int PROVIDER_NPI_NOT_VALID = 4136;
	public static final int INVALID_DATE = 4137;
	public static final int DUPLICATE_INSURANCE = 4138;
	public static final int INVALID_RELATIONSHIP_ADD_COVERAGE = 4139;
	public static final int INVALID_EMAIL_ADD_COVERAGE = 4140;

	public static final int TREATMENT_PLAN_EMPTY_PHASE = 4141;
	public static final int TREATMENT_PHASE_EMPTY_PROCEDURE = 4142;
	public static final int APPOINTMENTS_EXISTING_IN_THE_OLD_AVAILABILITY = 4143;
	public static final int NOT_SUBSCRIBER = 4144;
	public static final int CONFLICTING_SCHEDULE = 4145;
	public static final int INVALID_TREATMENT_PHASE_REQUEST = 4146;
	public static final int TREATMENTPHASE_SCHEDULED = 4147;
	public static final int PENDING_APPOINTMENTS_PATIENT = 4148;
	public static final int PENDING_APPOINTMENTS_AND_TRT_PLANS = 4149;
	public static final int PENDING_TRT_PLANS = 4150;
	public static final int USER_EXISTS_IN_TWO_IND_PRACTICES = 4151;

	public static final int INVALID_PROPOSED_DATE_RANGE = 4152;
	public static final int INVALID_TIME = 4153;
	public static final int NODE_VACATION = 4154;
	public static final int TREATMENT_OPTION_OFFERED_STATUS_REQUIRED = 4155;
	public static final int MINIMUM_TWO_TREATMENT_OPTIONS_REQUIRED = 4156;
	public static final int INVALID_TREATMENT_PLAN_STATUS = 4157;
	public static final int CANNOT_ADD_PRACTICE_UNDER_PRACTICE = 4158;
	public static final int INVALID_TIME_RANGE = 4159;
	public static final int TREATMENT_OPTION_ACCEPTED_CANNOT_BE_REJECTED = 4160;
	public static final int TREATMENT_PLAN_CANNOT_BE_COMPLETED = 4161;
	public static final int PROCEDURES_ALREADY_EXISTS_IN_TREATMENT = 4162;
	public static final int INVALID_STATUS = 4163;

	public static final int SSN_TIN_EXISTS = 4164;
	public static final int SUBSCRIBER_EXISTS = 4165;
	public static final int PROVIDER_NPI_MISMATCH = 4166;
	public static final int PROVIDER_NPI_ALREADY_REGISTERED = 4167;
	public static final int NODE_CANNOT_BE_ACTIVATED = 4168;
	public static final int PATIENT_ALREADY_EXISTS = 4169;
	public static final int CANNOT_ADD_SELF_AS_SUBSCRIBER = 4170;
	public static final int CANNOT_ADD_SELF_AS_DEPENDENT = 4171;
	public static final int ALREADY_ACCESS_GRANTED = 4172;
	public static final int INVALID_TREATMENT_CODE = 4173;
	public static final int CANNOT_DELETE_LAST_TREATMENT_OPTION = 4174;
	public static final int CANNOT_DELETE_LAST_TREATMENT_VISIT = 4175;
	public static final int ACCESS_TO_TP_ALREADY_REQUESTED = 4176;

	public static final int CHAIR_NAME_ALREADY_EXISTS = 4177;
	public static final int CHAIR_APPOINTMENT_SCHEDULED = 4178;
	public static final int INVALID_CHAIR_ID = 4179;

	public static final int INVALID_SSN = 4180;
	public static final int PATIENT_NOT_EXISTS = 4181;
	public static final int PLAN_CANNOT_BE_DEETED = 4182;
	public static final int CANNOT_ADD_RESPONSIBLE_PARTY = 4183;
	public static final int CANNOT_ADD_SUBSCRIBER = 4184;
	public static final int SSN_DOES_NOT_MATCH = 4185;
	public static final int SSN_DOES_NOT_EXIST = 4186;

	public static final int CANNOT_DELETE_NOTE = 4185;
	public static final int CANNOT_EDIT_NOTE = 4186;
	public static final int INVALID_STATE_CODE = 4187;

	public static final int APPOINTMENT_CANT_MOVE_IN_TREATMENT = 4188;
	public static final int CANNOT_ADD_TREATMENTS = 4189;
	public static final int CANNOT_VERIFY_TREATMENT = 4190;
	public static final int CANNOT_EDIT_TREATMENT = 4191;
	public static final int CANNOT_UPDATE_APPOINTMENT_FEE = 4192;
	public static final int CANNOT_REMOVE_TREATMENT = 4193;

	public static final int JSON_PARSING_ERROR = 4194;
	public static final int APPOINTMENT_CANT_BE_UPDATED_DATE_MISMATCH = 4195;
	public static final int APPOINTMENT_WITH_PROCEDURES_NOT_VERIFIED = 4196;

	public static final int INVALID_CHECK_IN_TIME = 4197;
	public static final int INVALID_START_TIME = 4198;
	public static final int INVALID_TREATMENT_TIME = 4199;
	public static final int APPOINTMENT_WITHOUT_TREATMENTS = 4200;

}
