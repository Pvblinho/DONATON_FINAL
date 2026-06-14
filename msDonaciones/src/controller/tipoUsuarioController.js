import {tipoUsuarioService} from '../services/tipoUsuarioService.js';

const getTipoUsuarioById = async (req, res) => {
    const { id } = req.params;
    try {
        const tipo = await tipoUsuarioService.getTipoUsuarioById(id);
        if (tipo) {
            res.json(tipo);
        } else {
            res.status(404).json({ message: 'Tipo de usuario no encontrado' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al obtener el tipo de usuario', error });
    }
}

const createTipoUsuario = async (req, res) => {
    const tipoData = req.body;
    try {
        const newTipo = await tipoUsuarioService.createTipoUsuario(tipoData);
        res.status(201).json(newTipo);
    } catch (error) {
        res.status(500).json({ message: 'Error al crear el tipo de usuario', error });
    }
}

const updateTipoUsuario = async (req, res) => {
    const { id } = req.params;
    const tipoData = req.body;
    try {
        const updatedTipo = await tipoUsuarioService.updateTipoUsuario(id, tipoData);
        if (updatedTipo[0] === 1) {
            res.json({ message: 'Tipo de usuario actualizado correctamente' });
        } else {
            res.status(404).json({ message: 'Tipo de usuario no encontrado' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al actualizar el tipo de usuario', error });
    }
}

const deleteTipoUsuario = async (req, res) => {
    const { id } = req.params;
    try {
        const deleted = await tipoUsuarioService.deleteTipoUsuario(id);
        if (deleted) {
            res.json({ message: 'Tipo de usuario eliminado correctamente' });
        } else {
            res.status(404).json({ message: 'Tipo de usuario no encontrado' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error al eliminar el tipo de usuario', error });
    }
}

export {
    getTipoUsuarioById,
    createTipoUsuario,
    updateTipoUsuario,
    deleteTipoUsuario
}