package com.ryuken.spring_boot_crash_course.controllers

import com.ryuken.spring_boot_crash_course.controllers.NoteController.NoteResponse
import com.ryuken.spring_boot_crash_course.database.repository.NoteRepository
import com.ryuken.spring_boot_crash_course.model.Note
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/notes")
class NoteController(private val repository: NoteRepository) {

    data class NoteRequest(
        val title: String,
        val id: String?,
        val content: String,
        val color: Long,
        val ownerId: String?
    )

    data class NoteResponse(
        val id: String,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant
    )

    @PostMapping
    fun save(@RequestBody body: NoteRequest): NoteResponse {
        val note = repository.save(
            Note(
                id = body.id?.let { ObjectId(it) } ?: ObjectId.get(),
                title = body.title,
                content = body.content,
                color = body.color,
                ownerId = body.ownerId?.let { ObjectId(it) } ?: ObjectId.get(),
                createdAt = Instant.now()
            )
        )

        return note.toResponse()
    }

    @GetMapping
    fun findByOwnerId(
        @RequestParam(required = false) ownerId: String?
    ): List<NoteResponse> {
        if (ownerId.isNullOrBlank()) return emptyList()
        return repository.findByOwnerId(ObjectId(ownerId)).map { it.toResponse() }
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteById(@PathVariable id: String): ResponseEntity<Void> {
        repository.deleteById(ObjectId(id))
        return ResponseEntity.noContent().build()
    }
}


private fun Note.toResponse(): NoteResponse = NoteResponse(
    id = id.toHexString(),
    title = title,
    content = content,
    color = color,
    createdAt = createdAt
)
