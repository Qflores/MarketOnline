   <!-- Modal HTML Markup -->
    <div id="ModalLoginForm" class="modal fade">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <h1>Actualizacion de Producto!</h1>
                    <form role="form" method="POST" action="">
                        <input type="hidden" name="_token" value="">
                        <div class="form-group">
                            <label class="control-label">Username</label>
                            <div>
                                <input type="text" class="form-control input-lg" name="name" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">E-Mail Address</label>
                            <div>
                                <input type="email" class="form-control input-lg" name="email" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Password</label>
                            <div>
                                <input type="password" class="form-control input-lg" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Confirm Password</label>
                            <div>
                                <input type="password" class="form-control input-lg" name="password_confirmation">
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <button type="submit" class="btn btn-success">
                                    Register
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
