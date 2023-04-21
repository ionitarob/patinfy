package cat.urv.deim.asm.patinfly

class SignUpInteractor {
    interface OnSignupListener {
        fun setFirstNameError()
        fun setLastNameError()
        fun setEmailError()
        fun setPhoneError()
        fun setIDError()
        fun setNationalityError()
        fun setKm()
        fun onSuccess()
    }

    fun signUp(firstName: String, lastName: String, email: String, phone: Int, id: String, nationality: String, km: Int, listener: OnSignupListener): Boolean {
        var success = false

        if (firstName.isEmpty()) {
            listener.setFirstNameError()
        }
        if (lastName.isEmpty()){
            listener.setFirstNameError()
        }
        if (email.isEmpty()){
            listener.setEmailError()
        }
        if (phone.toString().isEmpty()){
            listener.setPhoneError()
        }

        if (id.isEmpty()){
            listener.setIDError()
        }

        if (nationality.isEmpty()){
            listener.setNationalityError()
        }

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && phone.toString().isNotEmpty() &&
            id.isNotEmpty() && nationality.isNotEmpty() && km.toString().isNotEmpty()){
            success = true
        }
        return success
    }
}