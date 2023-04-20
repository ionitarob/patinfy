package cat.urv.deim.asm.patinfly

class ProfilePresenter(private var ProfileView: ProfileView?, private var ProfileInteractor: ProfileInteractor):
    ProfileInteractor.OnUpdateListener{

    fun verifyData(firstName: String, lastName: String, email: String, password: String?,  phone: Int, id: String, nationality: String, km: Int): Boolean{
        ProfileView?.showProgress()
        return ProfileInteractor.update(firstName, lastName, email, password, phone, id, nationality, km, this)
    }

    override fun setFirstNameError(){
        ProfileView?.apply {
            setFirstNameError()
            hideProgress()
        }
    }
    override fun setLastNameError(){
        ProfileView?.apply {
            setLastNameError()
            hideProgress()
        }
    }
    override fun setEmailError(){
        ProfileView?.apply {
            setEmailError()
            hideProgress()
        }
    }
    override fun setPhoneError(){
        ProfileView?.apply {
            setPhoneError()
            hideProgress()
        }
    }
    override fun setIDError(){
        ProfileView?.apply {
            setIDError()
            hideProgress()
        }
    }
    override fun setNationalityError(){
        ProfileView?.apply {
            setNationalityError()
            hideProgress()
        }
    }

    override fun setKmError(){
        ProfileView?.apply {
            setKmError()
            hideProgress()
        }

    }
    override fun onSuccess(){
        ProfileView?.navigateToProfile()
    }
}