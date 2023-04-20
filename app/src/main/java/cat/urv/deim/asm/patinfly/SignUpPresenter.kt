package cat.urv.deim.asm.patinfly

class SignUpPresenter(private var SignUpView: SignUpView?, private var SignUpInteractor: SignUpInteractor):
    SignUpInteractor.OnSignupListener{

    fun verifyData(firstName: String, lastName: String, email: String, password: String?,  phone: Int, id: String, nationality: String, km: Int): Boolean{
        SignUpView?.showProgress()
        return SignUpInteractor.signUp(firstName, lastName, email, password, phone, id, nationality, km, this)
    }

    override fun setFirstNameError(){
        SignUpView?.apply {
            setFirstNameError()
            hideProgress()
        }
    }
    override fun setLastNameError(){
        SignUpView?.apply {
            setLastNameError()
            hideProgress()
        }
    }
    override fun setEmailError(){
        SignUpView?.apply {
            setEmailError()
            hideProgress()
        }
    }
    override fun setPhoneError(){
        SignUpView?.apply {
            setPhoneError()
            hideProgress()
        }
    }
    override fun setIDError(){
        SignUpView?.apply {
            setIDError()
            hideProgress()
        }
    }
    override fun setNationalityError(){
        SignUpView?.apply {
            setNationalityError()
            hideProgress()
        }
    }

    override fun setKm(){
        SignUpView?.apply {
            setKm()
            hideProgress()
        }

    }
    override fun onSuccess(){
        SignUpView?.navigateToPassword()
    }

}