import {categoriaService} from '../services/categoriaService.js';

const getCategoriaById = async (req, res) => {
    const { id } = req.params;
    try {
        const categoria = await categoriaService.getCategoriaById(id);
        if (categoria) {
            res.json(categoria);
        } else {
            res.status(404).json({ message: 'Categoría no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al obtener la categoría', error });
    }
}

const createCategoria = async (req, res) => {
    const categoriaData = req.body;
    try {
        const newCategoria = await categoriaService.createCategoria(categoriaData);
        res.status(201).json(newCategoria);
    } catch (error) {
        res.status(500).json({ message: 'Error al crear la categoría', error });
    }
}

const updateCategoria = async (req, res) => {
    const { id } = req.params;
    const categoriaData = req.body;
    try {
        const updatedCategoria = await categoriaService.updateCategoria(id, categoriaData);
        if (updatedCategoria[0] === 1) {
            res.json({ message: 'Categoría actualizada correctamente' });
        } else {
            res.status(404).json({ message: 'Categoría no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al actualizar la categoría', error });
    }
}

const deleteCategoria = async (req, res) => {
    const { id } = req.params;
    try {
        const deleted = await categoriaService.deleteCategoria(id);
        if (deleted) {
            res.json({ message: 'Categoría eliminada correctamente' });
        } else {
            res.status(404).json({ message: 'Categoría no encontrada' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al eliminar la categoría', error });
    }
}

export {
    getCategoriaById,
    createCategoria,
    updateCategoria,
    deleteCategoria
}