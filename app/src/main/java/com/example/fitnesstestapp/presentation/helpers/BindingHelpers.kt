package com.example.fitnesstestapp.presentation.helpers

inline fun bindingLifecycleError(): Nothing = throw IllegalStateException(
    "This property is only valid between onCreateView and onDestroyView."
)