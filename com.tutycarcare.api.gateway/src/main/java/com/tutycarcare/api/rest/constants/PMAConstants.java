package com.tutycarcare.api.rest.constants;

import java.util.HashMap;
import java.util.Map;

public interface PMAConstants {
	
	public static final String HYGIENIST_CODE = "124Q00000X";
	
	public static enum PMA_ACCOUNT_STATUS {
		ACTIVE, PENDING, INVITED, NOTACTIVE, DISABLED, INACTIVE
	}

	public static enum PMA_REGISTER_AS_OPTIONS {
		Provider("Provider"), CorporatePractice("Corporate"), IndependentPractice("Independent Practice");

		private final String name;

		private PMA_REGISTER_AS_OPTIONS(String s) {
			name = s;
		}

		public String toString() {
			return this.name;
		}
	}

	public static enum NODE_TYPE {
		INDEPENDENT(2), CORPORATE(1), BILLING(3), PRACTICE(4);
		private int value;

		NODE_TYPE(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		private static Map<Integer, NODE_TYPE> map = new HashMap<Integer, NODE_TYPE>();

		static {
			for (NODE_TYPE nodeType : NODE_TYPE.values()) {
				map.put(nodeType.value, nodeType);
			}
		}

		public static NODE_TYPE valueOf(int value) {
			return map.get(value);
		}
	}

	public final static String PROVIDER = "Provider";
	public final static String OFFICE_STAFF = "Office Staff";
	public final static String OFFICE_MANAGER = "Office Manager";
	public final static String ADMIN = "Admin";
	public final static String ALL_LOCATIONS = "All Locations";
	public static final int INVALID_USER_ID = 0;
	public static final int INVALID_ID = 0;

	public static final String ENUM_TYPE_RENDERING_NPI = "NPI-1";
	public static final String ENUM_TYPE_BILLING_NPI = "NPI-2";

	public static enum ROLES {
		Provider(1, PROVIDER), OfficeStaff(2, OFFICE_STAFF), OfficeManager(3, OFFICE_MANAGER), Admin(4, ADMIN);

		private final String name;
		private final int id;

		private ROLES(int id, String name) {
			this.name = name;
			this.id = id;
		}

		public static ROLES getRolesById(int roleId) {
			switch (roleId) {
			case 1:
				return ROLES.Provider;
			case 2:
				return ROLES.OfficeStaff;
			case 3:
				return ROLES.OfficeManager;
			default:
				return null;
			}
		}

		public static int getRolesIdByProfession(String profession) {
			switch (profession) {
			case "Provider":
				return ROLES.Provider.id;
			case "Office Staff":
				return ROLES.OfficeStaff.id;
			case "Office Manager":
				return ROLES.OfficeManager.id;
			default:
				return 0;
			}
		}

		public int getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}
	}

	public static enum SYSTEM_FUNCTIONS {
		ProviderManagement(1), Members(2), TreatmentPlan(3), Procedure(4), Appointments(5), Claims(6), Users(7),  Hierarchy(8),
		Report(9), Revenue(10), Branding(11);
		private int value;

		SYSTEM_FUNCTIONS(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	public static enum SYSTEM_ACTIONS {
		GET(1, "View"), PUT(2, "Add"), POST(3, "Edit"), DELETE(4, "Delete");
		private int value;
		private String action;

		SYSTEM_ACTIONS(int value, String action) {
			this.action = action;
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public String getAction() {
			return this.action;
		}

		public static boolean contains(String string) {
			for (SYSTEM_ACTIONS action : values()) {
				if (action.name().equals(string)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static int MAX_INDEPENDENT_LOCATION = 2;
}
