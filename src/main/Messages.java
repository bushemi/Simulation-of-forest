package main;

public enum Messages {
  STANDART(0, "(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it : "),
  ERR_NO_FOREST(1, "No forest"),
  NEW_FOREST_NAME(2, "What is the forest name :"),
  REAP_MSG(3, "What height to reap at : "),
  ERR_INVALID_HEIGHT(4, "ERROR: Invalid height"),
  ERR_INVALID_OPTION(5, "ERROR: Invalid option"),
  ERR_INVALID_FILE_NAME(6, "ERROR: Invalid height");
  private final int code;
  private final String description;

  private Messages(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getDescription() {
     return description;
  }

  public int getCode() {
     return code;
  }

  @Override
  public String toString() {
    return code + ": " + description;
  }
}