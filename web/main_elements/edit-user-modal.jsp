<div class="modal fade" id="editUserModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editStudentLabel" aria-hidden="true">
  <div class="modal-dialog mt-5">
    <div class="modal-content">
      <div class="modal-header text-center">
        <div class="modal-title mb-3 text-center">
          <h5><%= currentLocale.get("edit") %></h5>
        </div>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body row col-12 rounded align-self-center" style="background-color: #f7f7ff;">
        <form action="/edit-user-profile" method="post">
          <div class="mb-3 mt-3">
            <label for="name" class="form-label"><%= currentLocale.get("name") %></label>
            <input type="text" class="form-control" id="name" name="full_name" value="<%= activeUser.getFullName() %>">
          </div>
          <div class="mb-3 ">
            <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("email") %></label>
            <input type="email" class="form-control" id="exampleInputEmail" name="email" value="<%= activeUser.getEmail() %>">
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("password") %></label>
            <input type="password" class="form-control" id="exampleInputPassword" name="password" value="<%= activeUser.getPassword() %>">
          </div>
          <div class="d-flex justify-content-center">
            <button class="btn b-group w-50 mt-4"><%= currentLocale.get("edit") %></button>
          </div>
        </form>
      </div>
      <div class="modal-footer justify-content-center">
        <button type="button" class="btn btn-main w-50" data-bs-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>