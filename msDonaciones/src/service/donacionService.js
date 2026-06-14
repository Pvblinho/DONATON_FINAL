import donacionRepository from '../repository/donacionRepository.js';

const getDonacionById = (id) => donacionRepository.getDonacionById(id);

const createDonacion = ({monto, categoriaId, usuarioId}) => {
    validateDonacion({monto, categoriaId, usuarioId});
    return donacionRepository.createDonacion({monto, categoriaId, usuarioId});
};

const updateDonacion = (id, {monto, categoriaId, usuarioId}) => {
    validateDonacion({monto, categoriaId, usuarioId});
    return donacionRepository.updateDonacion(id, {monto, categoriaId, usuarioId});
};

const deleteDonacion = (id) => donacionRepository.deleteDonacion(id);

const validateDonacion = (donacion) => {
    if (!donacion.monto || donacion.monto <= 0) {
        throw new Error('El monto de la donación debe ser mayor a cero.');
    }
    if (!donacion.categoriaId) {
        throw new Error('La categoría de la donación es obligatoria.');
    }
    if (!donacion.usuarioId) {
        throw new Error('El usuario que realiza la donación es obligatorio.');
    }
}

export default {
    getDonacionById,
    createDonacion,
    updateDonacion,
    deleteDonacion
}