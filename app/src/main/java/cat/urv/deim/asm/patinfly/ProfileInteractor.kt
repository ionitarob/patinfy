package cat.urv.deim.asm.patinfly

class ProfileInteractor {
    interface OnUpdateListener {
        fun setFirstNameError()
        fun setLastNameError()
        fun setEmailError()
        fun setPhoneError()
        fun setIDError()
        fun setNationalityError()
        fun setKmError()
        fun onSuccess()
    }

    fun update(firstName: String, lastName: String, email: String, password: String?, phone: Int, id: String, nationality: String, km: Int, listener: OnUpdateListener): Boolean {
        var success = false
        password.equals(null)
        if (firstName.isEmpty()){
            listener.setFirstNameError()
        }
        if (lastName.isEmpty()){
            listener.setLastNameError()
        }
        if (email.isEmpty()){
            listener.setEmailError()
        }
        if (phone == 0){
            listener.setPhoneError()
        }
        if (id.isEmpty()){
            listener.setIDError()
        }
        if (nationality.isEmpty()){
            listener.setNationalityError()
        }
        if (km.equals(null)) {
            listener.setKmError()
        }

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && phone != 0 &&
            id.isNotEmpty() && nationality.isNotEmpty() && !km.equals(null)){
            success = true
        }

        return success
    }
}
