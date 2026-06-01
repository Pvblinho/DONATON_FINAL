import express from 'express';
import db from '../config/db.js';
import verifyToken from '../middleware/auth.js';
import {categoriaController} from '../controllers/categoriaController.js';

const router = express.Router();

router.use(verifyToken);

// get /categorias listar todas las categorias
router.get('/', categoriaController.getAllCategorias);

//get /categorias/:id obtener una categoria por id
router.get('/:id', categoriaController.getCategoriaById);

//post /categorias crear una nueva categoria
router.post('/', verifyToken, categoriaController.createCategoria);

//put /categorias/:id actualizar una categoria por id
router.put('/:id', verifyToken, categoriaController.updateCategoria);

//delete /categorias/:id eliminar una categoria por id
router.delete('/:id', verifyToken, categoriaController.deleteCategoria);

export default router;