import {categoriaRepository} from '../repository/categoriaRepository.js';

const getCategoriaById = (id) => categoriaRepository.getCategoriaById(id);

const createCategoria = ({nombre}) => {
    validateCategoriaData({nombre});
    return categoriaRepository.createCategoria({
        nombre: nombre.trim()
    });
};

const updateCategoria = (id, {nombre}) => {
    validateCategoriaData({nombre});
    return categoriaRepository.updateCategoria(id, {
        nombre: nombre.trim()
    });
};

const deleteCategoria = (id) => {
    return categoriaRepository.deleteCategoria(id);
};

const validateCategoriaData = ({nombre}) => {
    if (!nombre) {
        throw new Error('El campo nombre es obligatorio');
    }
    if (typeof nombre !== 'string') {
        throw new Error('El campo nombre debe ser de tipo string');
    }
}

export default {
    getCategoriaById,
    createCategoria,
    updateCategoria,
    deleteCategoria,
    validateCategoriaData
}