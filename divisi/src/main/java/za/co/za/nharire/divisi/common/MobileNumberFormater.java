package za.co.nharire.divisi.common;;

public interface MobileNumberFormater {
  String formatMsisdnMinimum(String msisdn);

  boolean isValidMsisdn(String msisdn);

  String formatMobileNumberInternational(String msisdn);
}
