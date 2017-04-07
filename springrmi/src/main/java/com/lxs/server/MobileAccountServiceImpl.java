package com.lxs.server;

/**
 * Created by carry on 17-1-3.
 */
public class MobileAccountServiceImpl implements AccountService {

    @Override
    public String shoopingPayment(String mobileNo, byte protocol) {
        StringBuffer sb =
                new StringBuffer().append("Your mobile number is \"").append(mobileNo).append("\", protocol type is \"")
                        .append(protocol).append("\".");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
