import {users} from "../models/users.js";

const getUserById = (id) => {
    return users.findByPk(id);
}

const createUser = (user) => {
    return users.create(user);
}
const updateUser = (id, user) => {
    return users.update(user, {
        where: { id }
    });
}

const deleteUser = (id) => {
    return users.destroy({
        where: { id }
    });
}

export {
    getUserById,
    createUser,
    updateUser,
    deleteUser
}