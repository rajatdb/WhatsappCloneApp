package whatsappcloneapp.rajat_pc.project.com.whatsappcloneapp.models

class Users() {
    var display_name: String? = null
    var image: String? = null
    var thumb_image: String? = null
    var user_status: String? = null

    constructor(display_name: String, image: String,
                thumb_image: String, user_status: String): this(){
        this.display_name = display_name
        this.image = image
        this.thumb_image = thumb_image
        this.user_status = user_status
    }
}