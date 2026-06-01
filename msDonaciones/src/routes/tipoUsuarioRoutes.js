import express from "express";
import db from "../config/db.js";
import verifyToken from "../middleware/auth.js";
import { tipoUsuarioController } from "../controllers/tipoUsuarioController.js";

const router = express.Router();

router.use(verifyToken);

// get /tipos-usuario listar todas los tipos de usuario
router.get("/", tipoUsuarioController.getAllTiposUsuario);

//get /tipos-usuario/:id obtener un tipo de usuario por id
router.get("/:id", tipoUsuarioController.getTipoUsuarioById);

//post /tipos-usuario crear un nuevo tipo de usuario
router.post("/", verifyToken, tipoUsuarioController.createTipoUsuario);

//put /tipos-usuario/:id actualizar un tipo de usuario por id
router.put("/:id", verifyToken, tipoUsuarioController.updateTipoUsuario);

//delete /tipos-usuario/:id eliminar un tipo de usuario por id
router.delete("/:id", verifyToken, tipoUsuarioController.deleteTipoUsuario);

export default router;