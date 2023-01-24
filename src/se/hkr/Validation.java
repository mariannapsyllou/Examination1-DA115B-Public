package se.hkr;



    @FunctionalInterface
    interface Validation{
        boolean isValid(String string);
    }
    //String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    //NameEmailValidation valid = NameOrMail-> NameOrMail.matches(regex);



