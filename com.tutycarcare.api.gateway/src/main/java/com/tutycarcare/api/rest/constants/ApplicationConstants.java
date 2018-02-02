package com.tutycarcare.api.rest.constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public interface ApplicationConstants {

	public static final String DEFAULT_START_TIME = "DEFAULT_START_TIME";
	public static final String DEFAULT_END_TIME = "DEFAULT_END_TIME";

	/* To be used to identify app user for audit purposes */
	public static final String USER = "PMA_USER";
	public static final String MEMBER = "PEA_MEMBER";
	public static final String BATCH_PROCESSOR = "BATCH_PROCESSOR";

	public static final String DOT = ".";
	public static final String UNDERSCORE = "_";
	public static final String EQUAL_TO = "=";
	public static final String AMPERSAND = "&";
	public static final String COLON = ":";
	public static final String QUOTES = "\"";
	public static final String USER_ID = "userId";
	public static final String MEMBER_ID = "memberId";
	public static final String NODE_ID = "nodeId";
	public static final String APPOINTMENT_ID = "applicationId";
	public static final String QUESTION_MARK = "?";
	public static final String ENCODED_TAG = "id";
	public static final String PROFILE = "profile";

	public static final String LINK_GENERATION_TIME = "time";
	public static final String IS_VALID_EMAIL_KEY = "is_valid";
	public static final String MAIL_ADDRESS = "address";
	public static final String MAIL_API_KEY = "api_key";
	public static final String MAIL_API = "api";
	public static final String MAIL_FROM = "from";
	public static final String MAIL_TO = "to";
	public static final String MAIL_HTML = "html";
	public static final String MAIL_SUBJECT = "subject";
	public static final String S3_FOLDER_MEMBER = "member";
	public static final String S3_FOLDER_USER = "user";
	public static final String S3_FOLDER_NODE = "node";
	public static final String INSURANCE_PLAN = "insurance_plan";
	public static final String TRANSACTION_MANAGER = "transactionManager";
	public static final String TRANSACTION_MANAGER1 = "transactionManager1";

	public static enum DAYS_OF_WEEK {
		Monday(2), Tuesday(3), Wednesday(4), Thursday(5), Friday(6), Saturday(7), Sunday(1);
		int id;

		DAYS_OF_WEEK(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}
	}

	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";
	public static final String MESSAGE = "Message";
	public static final String INSURANCE_LOOKUP_KEY = "Insurance";
	public static final String SURFACE_LOOKUP_KEY = "Surface";
	public static final String QUADRANT_LOOKUP_KEY = "Quadrant";
	public static final String RELATIONSHIP_SUB = "Relationship_Sub";
	public static final String RELATIONSHIP_RP = "Relationship_RP";
	public static final String PLAN_TYPE_KEY = "Plan_Type";
	public static final String PLAN_TYPE_DB = "Plan Type";

	public static final String ADDRESS_FORMAT_DELIMITER = ", ";
	public static final String ADDRESS_FORMAT_ZIPCODE_DELIMITER = " ";

	public static final String UTC_TIME_ZONE_PROVIDER = "UTC";

	public static final String DEFAULT_PAGE_NUM = "1";
	public static final String DEFAULT_ITEMS_PER_PAGE = "10";

	public static final String MEMBER_TABLE_NAME = "member";
	public static final String USER_TABLE_NAME = "user";
	public static final String NODE_TABLE_NAME = "n";
	public static final String PROCEDURES_TABLE_NAME = "procedures";
	public static final String NODE_EXPLOSION_TABLE_NAME = "node_explosion";
	public static final String TREATMENT_PLAN_TABLE = "t"; // alias has been
															// used for joining
	public static final String APPOINTMENT_TABLE = "a"; // alias has been used
														// for joining
	public static final String APPOINTMENT_REQUEST_TABLE = "ar";
	public static final String SORT_BY_ASCENDING = "ASC";
	public static final String SORT_BY_DESCENDING = "DESC";
	public static final String PROVIDER_PROCEDURE_DURATION = "p";
	public static final String OPERATORY_TABLE_NAME = "operatory";

	public static final String SECRET_CODE = "code";

	public static enum PASSWORD_STATUS {
		RESET, ACTIVE
	}

	public static enum APPOINTMENT_REQUEST_STATUS {
		REQUESTED, RESOLVED, PENDING_FOR_CANCELLATION, PENDING_FOR_RESCHEDULE, CANCELLED
	}

	public static final String ZERO_STRING = "0";
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final String SELF_RELATIONSHIP = "Self";
	public static final String EMPTY_SPACE = "";
	public static final String SPACE = " ";

	// for graph key in dash board UI
	public static final String MISSED_APPOINTMNETS = "Missed";

	// Credential Type for Dental Exchange Service
	public static final String CREDENTIAL_TYPE = "TJ";

	public static final int SELF_RELATIONSHIP_CODE = 18;

	public static final String COMMA = ",";

	public static final String RESPONSIBLE_PARTY = "RESPONSIBLE_PARTY";

	public static final String EMPLOYERS_LOOKUP_KEY = "employers";

	public static final String PLAN_NAME_LOOKUP_KEY = "planName";

	public static final String RELATIONSHIP_SUB_DB = "Subscriber Relationship";

	public static final String RELATIONSHIP_RP_DB = "Responsible Party Relationship";

	public static final String CHAIR_COLOR = "Chair Color";

	public static final String DATE = "date";

	public static final String CARRIER_TABLE = "c";

	public static enum TREATMENT_PLAN_STATUS_ENUM {
		OPEN("OPEN"), IN_PROGRESS("INPRG"), COMPLETED("DONE"), CANCELLED("Cancelled");
		String id;

		private TREATMENT_PLAN_STATUS_ENUM(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return this.id;
		}
	}

	public static enum TREATMENT_PLAN_STATUS {
		OFFERED("Offered", 619), ACCEPTED("Accepted", 654), ON_HOLD("On Hold", 345), REJECTED("Rejected",
				193), OPEN("Open", 876), COMPLETED("Completed", 243), CLOSED("Closed", 543);
		String status;
		int id;

		private TREATMENT_PLAN_STATUS(String status, int id) {
			this.status = status;
			this.id = id;
		}

		private static Map<Integer, TREATMENT_PLAN_STATUS> map = new HashMap<Integer, TREATMENT_PLAN_STATUS>();

		static {
			for (TREATMENT_PLAN_STATUS status : TREATMENT_PLAN_STATUS.values()) {
				map.put(status.id, status);
			}
		}

		public static TREATMENT_PLAN_STATUS valueOf(int value) {
			return map.get(value);
		}

		public int getValue() {
			return this.id;
		}

		@Override
		public String toString() {
			return status;
		}
	}

	public static enum TREATMENT_OPTIONS_STATUS {
		OFFERED("Offered"), ACCEPTED("Accepted"), REJECTED("Rejected"), CANCELLED("Cancelled");
		String id;

		private TREATMENT_OPTIONS_STATUS(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return this.id;
		}
	}

	public static enum TREATMENT_PHASE_STATUS_ENUM {
		COMPLETED("DONE"), CANCELLED("Cancelled"), SCHEDULED("Scheduled"), PENDING_FOR_SCHEDULING(
				"PENDING(S)"), PENDING_CNF("PENDING(C)"), CLOSED("Closed");
		String id;

		private TREATMENT_PHASE_STATUS_ENUM(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return this.id;
		}
	}

	public static enum APPOINTMENT_NOTIFICATION_TYPE {
		CREATE, CONFIRM, RESCHEDULE, CANCEL
	}

	public static enum APPOINTMENT_STATES {
		SCHEDULED("Scheduled",
				new APPOINTMENT_STATUS_ENUM[] { APPOINTMENT_STATUS_ENUM.SCHEDULED, APPOINTMENT_STATUS_ENUM.CONFIRMED,
						APPOINTMENT_STATUS_ENUM.ARRIVED, APPOINTMENT_STATUS_ENUM.NO_SHOW },
				532), IN_TREATMENT("In_Treatment",
						new APPOINTMENT_STATUS_ENUM[] { APPOINTMENT_STATUS_ENUM.IN_TREATMENT,
								APPOINTMENT_STATUS_ENUM.TREATMENT_COMPLETED },
						906), IN_VERIFICATION("In_Verification",
								new APPOINTMENT_STATUS_ENUM[] { APPOINTMENT_STATUS_ENUM.IN_VERIFICATION },
								603), COMPLETED("Completed",
										new APPOINTMENT_STATUS_ENUM[] { APPOINTMENT_STATUS_ENUM.VERFICATION_COMPLETED,
												APPOINTMENT_STATUS_ENUM.COMPLETED },
										103);
		String state;
		APPOINTMENT_STATUS_ENUM[] status;
		int id;

		private APPOINTMENT_STATES(String state, APPOINTMENT_STATUS_ENUM[] statuses, int id) {
			this.state = state;
			this.status = statuses;
			this.id = id;
		}

		private static Map<Integer, APPOINTMENT_STATES> map = new HashMap<Integer, APPOINTMENT_STATES>();
		static {
			for (APPOINTMENT_STATES status : APPOINTMENT_STATES.values()) {
				map.put(status.id, status);
			}
		}

		public static APPOINTMENT_STATES valueOf(int value) {
			return map.get(value);
		}

		public static APPOINTMENT_STATUS_ENUM[] getStatuses(APPOINTMENT_STATES state) {
			Set<Integer> map1 = map.keySet();
			Iterator<Integer> ite = map1.iterator();
			while (ite.hasNext()) {
				int id = ite.next();
				if (state.toString().equalsIgnoreCase(APPOINTMENT_STATES.valueOf(id).toString())) {
					return state.status;
				}
			}
			return null;
		}

		public int getValue() {
			return this.id;
		}

		@Override
		public String toString() {
			return state;
		}

	}

	public static enum APPOINTMENT_STATUS_ENUM {
		REQUESTED("Requested", 369), CONFIRMED("Confirmed", 919), PENDING("Pending", 971), PENDING_R("Pending_R",
				519), PENDING_A("Pending_A", 519), DENIED("Denied", 739), CANCELLED("Cancelled", 531), PENDING_C(
						"Pending_C", 136), SCHEDULED("Scheduled", 915), BLOCKED("Blocked", 444), NO_SHOW("NoShow",
								101), COMPLETED("Completed", 119), ARRIVED("Arrived", 486), IN_TREATMENT("In_Treatment",
										734), TREATMENT_COMPLETED("Treatment_Completed", 459), IN_VERIFICATION(
												"In_Verification",
												961), VERFICATION_COMPLETED("Verification_Completed", 309);
		String status;
		int id;

		private APPOINTMENT_STATUS_ENUM(String status, int id) {
			this.status = status;
			this.id = id;
		}

		private static Map<Integer, APPOINTMENT_STATUS_ENUM> map = new HashMap<Integer, APPOINTMENT_STATUS_ENUM>();

		static {
			for (APPOINTMENT_STATUS_ENUM status : APPOINTMENT_STATUS_ENUM.values()) {
				map.put(status.id, status);
			}
		}

		public static APPOINTMENT_STATUS_ENUM valueOf(int value) {
			return map.get(value);
		}

		public static int getId(String code) {
			Set<Integer> map1 = map.keySet();
			Iterator<Integer> ite = map1.iterator();
			while (ite.hasNext()) {
				int id = ite.next();
				if (code.equalsIgnoreCase(APPOINTMENT_STATUS_ENUM.valueOf(id).toString())) {
					return id;
				}
			}
			return -1;
		}

		public int getValue() {
			return this.id;
		}

		public String getStatus() {
			return this.status;
		}

		@Override
		public String toString() {
			return status;
		}
	}

	public static enum TREATMENT_PHASE_ACTION_ENUM {
		DO_NOTHING("No Action"), INSERT_NEW("Add"), UPDATE("Update"), DELETE("Delete");
		String id;

		private TREATMENT_PHASE_ACTION_ENUM(String name) {
			this.id = name;
		}

		@Override
		public String toString() {
			return id;
		}
	}

	public static enum NODE_ADDRESS_TYPE_ENUM {
		TREATING_ADDRESS, PAY_TO_ADDRESS
	}

}
