import userRepository from "../repository/userRepository.js";

const getUserById = (id) => userRepository.getUserById(id);

const createUser = ({rut, nombre, email, password}) => {
    validateUserData({rut, nombre, email, password});
    return userRepository.createUser({
        rut,
        nombre: nombre.trim(),
        email,
        password
    });
};

const updateUser = (id, {rut, nombre, email, password}) => {
    validateUserData({rut, nombre, email, password});
    return userRepository.updateUser(id, {
        rut,
        nombre: nombre.trim(),
        email,
        password
    });
};

const deleteUser = (id) => {
    validateUserData({rut, nombre, email, password});
    return userRepository.deleteUser(id);
};

const validateUserData = ({rut, nombre, email, password}) => {
    if (!rut || !nombre || !email || !password) {
        throw new Error('Todos los campos son obligatorios');
    }
    if (typeof rut !== 'string' || typeof nombre !== 'string' || typeof email !== 'string' || typeof password !== 'string') {
        throw new Error('Todos los campos deben ser de tipo string');
    }
}

export default {
    getUserById,
    createUser,
    updateUser,
    deleteUser,
    validateUserData
}