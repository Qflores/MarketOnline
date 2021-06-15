
/* Default Notifications */

function default_noti(sms) {
    Lobibox.notify('default', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: '' + sms
    });
}


function info_noti(sms) {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        icon: 'fa fa-info-circle',
        msg: '' + sms
    });
}

function warning_noti(sms) {
    Lobibox.notify('warning', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        icon: 'fa fa-exclamation-circle',
        msg: '' + sms
    });
}

function error_noti(sms) {
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        icon: 'fa fa-times-circle',
        msg: '' + sms
    });
}

function success_noti(sms) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        showClass: 'fadeInDown',
        hideClass: 'fadeUpDown',
        icon: 'fa fa-check-circle',
        msg: '' + sms
    });
}




/* Rounded corners Notifications */

function round_default_noti(sms) {
    Lobibox.notify('default', {
        pauseDelayOnHover: true,
        size: 'mini',
        rounded: true,
        delayIndicator: false,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: '' + sms
    });
}


function round_info_noti(sms) {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        size: 'mini',
        rounded: true,
        icon: 'fa fa-info-circle',
        delayIndicator: false,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: '' + sms
    });
}

function round_warning_noti(sms) {
    Lobibox.notify('warning', {
        pauseDelayOnHover: true,
        size: 'mini',
        rounded: true,
        delayIndicator: false,
        icon: 'fa fa-exclamation-circle',
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: ''+sms
    });
}

function round_error_noti(sms) {
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        size: 'mini',
        rounded: true,
        delayIndicator: false,
        icon: 'fa fa-times-circle',
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: ''+sms
    });
}

function round_success_noti(sms) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        size: 'mini',
        rounded: true,
        icon: 'fa fa-check-circle',
        delayIndicator: false,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        msg: ''+sms
    });
}




/* Notifications With Images*/

function img_default_noti(sms,ruta) {
    Lobibox.notify('default', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        img: ruta,//'assets/plugins/notifications/img/1.jpg', //path to image
        msg: ''+sms
    });
}


function img_info_noti(sms, ruta) {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        icon: 'fa fa-info-circle',
        position: 'top right',
        img: ruta,
        msg: ''+sms
    });
}

function img_warning_noti(sms, ruta) {
    Lobibox.notify('warning', {
        pauseDelayOnHover: true,
        icon: 'fa fa-exclamation-circle',
        continueDelayOnInactiveTab: false,
        position: 'top right',
        img: ruta,
        msg: ''+sms
    });
}

function img_error_noti(sms,ruta) {
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        icon: 'fa fa-times-circle',
        position: 'top right',
        img: ruta,
        msg: ''+sms
    });
}

function img_success_noti(sms, ruta) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'top right',
        icon: 'fa fa-check-circle',
        img: ruta,
        msg: ''+sms
    });
}





/* Notifications With Images*/


function pos1_default_noti() {
    Lobibox.notify('default', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'center top',
        size: 'mini',
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function pos2_info_noti() {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        icon: 'fa fa-info-circle',
        continueDelayOnInactiveTab: false,
        position: 'top left',
        size: 'mini',
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function pos3_warning_noti() {
    Lobibox.notify('warning', {
        pauseDelayOnHover: true,
        icon: 'fa fa-exclamation-circle',
        continueDelayOnInactiveTab: false,
        position: 'top right',
        size: 'mini',
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function pos4_error_noti() {
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        icon: 'fa fa-times-circle',
        size: 'mini',
        continueDelayOnInactiveTab: false,
        position: 'bottom left',
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function pos5_success_noti(sms) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        size: 'mini',
        icon: 'fa fa-check-circle',
        continueDelayOnInactiveTab: false,
        position: 'bottom right',
        msg: ''+sms
    });
}




/* Animated Notifications*/


function anim1_noti() {
    Lobibox.notify('default', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'center top',
        showClass: 'fadeInDown',
        hideClass: 'fadeOutDown',
        width: 600,
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}


function anim2_noti() {
    Lobibox.notify('info', {
        pauseDelayOnHover: true,
        icon: 'fa fa-info-circle',
        continueDelayOnInactiveTab: false,
        position: 'center top',
        showClass: 'bounceIn',
        hideClass: 'bounceOut',
        width: 600,
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function anim3_noti() {
    Lobibox.notify('warning', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        icon: 'fa fa-exclamation-circle',
        position: 'center top',
        showClass: 'zoomIn',
        hideClass: 'zoomOut',
        width: 600,
        msg: 'Lorem ipsum dolor sit amet hears farmer indemnity inherent.'
    });
}

function anim4_noti(sms) {
    Lobibox.notify('error', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        icon: 'fa fa-times-circle',
        position: 'center top',
        showClass: 'lightSpeedIn',
        hideClass: 'lightSpeedOut',
        width: 600,
        msg: ''+sms
    });
}

function anim5_noti(sms) {
    Lobibox.notify('success', {
        pauseDelayOnHover: true,
        continueDelayOnInactiveTab: false,
        position: 'right top',
        showClass: 'rollIn',
        hideClass: 'rollOut',
        icon: 'fa fa-check-circle',
        width: 600,
        msg: ''+sms
    });
}