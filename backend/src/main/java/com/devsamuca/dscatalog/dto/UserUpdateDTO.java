package com.devsamuca.dscatalog.dto;

import com.devsamuca.dscatalog.services.validation.UserInsertValid;
import com.devsamuca.dscatalog.services.validation.UserUpdateValid;
import jakarta.validation.Valid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO {
}
